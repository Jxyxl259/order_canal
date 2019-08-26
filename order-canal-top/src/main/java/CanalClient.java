import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.alibaba.otter.canal.protocol.CanalEntry.Entry;
import static com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
import static com.alibaba.otter.canal.protocol.CanalEntry.RowData;
import static com.alibaba.otter.canal.protocol.CanalEntry.Column;
import static com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import static com.alibaba.otter.canal.protocol.CanalEntry.EntryType.*;
import java.net.InetSocketAddress;
import java.util.List;



/**
 * @description: canal 客户端
 * @author: jiangxy9
 * @create: 2019-08-23 16:18
 */
public class CanalClient {

    private static Logger log = LoggerFactory.getLogger(CanalClient.class);


    public static void main(String args[]) {
        // 创建链接
        CanalConnector connector = CanalConnectors.newSingleConnector(
                new InetSocketAddress("192.168.44.101",
                        11111), "example", "mysql", "mysql");
        int batchSize = 1000;
        //int emptyCount = 0;
        try {
            connector.connect();
            connector.subscribe(".*\\..*");
            connector.rollback();
            //int totalEmptyCount = 120;
            //while (emptyCount < totalEmptyCount) {
            while (true) {
                Message message = connector.getWithoutAck(batchSize); // 获取指定数量的数据
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    //emptyCount++;
                    //System.out.println("empty count : " + emptyCount);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                } else {
                    //emptyCount = 0;
                    // System.out.printf("message[batchId=%s,size=%s] \n", batchId, size);
                    printEntry(message.getEntries());
                }
                connector.ack(batchId); // 提交确认
                // connector.rollback(batchId); // 处理失败, 回滚数据
            }
            //System.out.println("empty too many times, exit");
        } catch(Exception e){
            log.error("del Msg error ->", e);
        } finally {
            connector.disconnect();
        }
    }


    private static void printEntry(List<Entry> entrys) {
        for (Entry entry : entrys) {
            if (entry.getEntryType() == TRANSACTIONBEGIN
                    || entry.getEntryType() == TRANSACTIONEND) {
                continue;
            }
            RowChange rowChage = null;
            try {
                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event " +
                        "has an error , data:" + entry.toString(), e);
            }
            EventType eventType = rowChage.getEventType();
            System.out.println(String.format("================&gt; " +
                            "binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                    eventType));
            for (RowData rowData : rowChage.getRowDatasList()) {
                if (eventType == EventType.DELETE) {
                    // 删除操作， 输出删除的数据， 类似
                    /**
                     * id : 1    update=false
                     * name : ee    update=false
                     * ip : e    update=false
                     */
                    printColumn(rowData.getBeforeColumnsList());
                } else if (eventType == EventType.INSERT) {
                    // 新增操作，输出新增的数据， 类似
                    /**
                     * id : 1    update=true
                     * name : dd    update=true
                     * ip : e    update=true
                     */
                    printColumn(rowData.getAfterColumnsList());
                } else {
                    // 更新操作， 输出更新前后的数据，类似
                    /**
                     * -------&gt; before
                     * id : 1    update=false
                     * name : dd    update=false
                     * ip : e    update=false
                     * -------&gt; after
                     * id : 1    update=false
                     * name : ee    update=true
                     * ip : e    update=false
                     */
                    System.out.println("-------&gt; before");
                    printColumn(rowData.getBeforeColumnsList());
                    System.out.println("-------&gt; after");
                    printColumn(rowData.getAfterColumnsList());
                }
            }
        }
    }



    private static void printColumn(List<Column> columns) {
        for (Column column : columns) {
            System.out.println(column.getName() +
                    " : " + column.getValue() +
                    "    update=" + column.getUpdated());
        }
    }

}
