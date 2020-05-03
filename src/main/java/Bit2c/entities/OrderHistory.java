package Bit2c.entities;

import Enums.AssetPairsEnum;
import lombok.*;

import java.util.HashMap;
import java.util.Map;
@Getter
@ToString
@Builder
@AllArgsConstructor
public class OrderHistory {
    private Long fromTime;
    private Long toTime;
    private int take;
    private AssetPairsEnum.AssetPairs pair;



    public static OrderHistory createOrderHistoryInput(Long fromTime, Long toTime, int take,AssetPairsEnum.AssetPairs pair) {
        var orderHistory = new OrderHistoryBuilder()
                .pair(pair)
                .fromTime(fromTime)
                .toTime(toTime)
                .take(take)
                .build();
        return orderHistory;
    }

    public static OrderHistory createOrderHistoryInput( AssetPairsEnum.AssetPairs pair, int take) {
        var orderHistory = new OrderHistoryBuilder()
                .pair(pair)
                .take(take)
                .build();
        return orderHistory;
    }
    public static OrderHistory createOrderHistoryInput(AssetPairsEnum.AssetPairs pair) {
        var orderHistory = new OrderHistoryBuilder()
                .pair(pair)
                .build();
        return orderHistory;
    }

    public static OrderHistory createOrderHistoryInput(int take) {
        var orderHistory = new OrderHistoryBuilder()
                .take(take)
                .build();
        return orderHistory;
    }

    public static OrderHistory createOrderHistoryInput(Long fromTime, Long toTime) {
        var orderHistory = new OrderHistoryBuilder()
                .fromTime(fromTime)
                .toTime(toTime)
                .build();
        return orderHistory;
    }


    public Map<String, Object> asMap () {
        var result = new HashMap<String, Object>();


        if (fromTime != null) {
            result.put("fromTime", fromTime);
        }
        if (toTime != null) {
            result.put("toTime", toTime);
        }

        if (take >0){
            result.put("take", take);
        }
        if (pair != null) {
            result.put("pair", pair);

        }

        return result;
    }
}
