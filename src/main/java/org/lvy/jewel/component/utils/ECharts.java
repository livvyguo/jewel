package org.lvy.jewel.component.utils;

import com.github.abel533.echarts.*;
import com.github.abel533.echarts.axis.AxisLabel;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.feature.*;
import com.github.abel533.echarts.series.*;

import java.util.List;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/3/10.
 */
public final class ECharts {
    private ECharts() {
        throw new AssertionError("no instance for you!");
    }


    /**
     * 获取饼图的画板
     * @param legend
     * @param <T>
     * @return
     */
    public static <T> Option newPieBoard(String title,List<T> legend) {
        return new Option().title(new Title().text(title).x("center")).
                tooltip(new Tooltip().trigger(Trigger.item).formatter(" {a} <br/>{b} : {c} ({d}%)")).
                calculable(true).
                legend(new Legend().
                        orient(Orient.vertical).
                        x("left").data(legend)
                ).
                toolbox(new Toolbox().show(true)
                                .feature(
//                                        new Mark().show(true),
                                        new DataView().show(true).readOnly(false),
//                                new MagicType().option(
//                                        new MagicType.Option().
//                                                funnel(new Funnel().
//                                                        x("25%").width("50%")
//                                                        .funnelAlign(X.left).max(1548)
//                                                )
//                                ).show(true).type(new String[]{"pie","funnel"}),
                                        new Restore().show(true)
                                        , new SaveAsImage().show(true)
                                )
                );
    }

    public static <LT> Option newPieBoard(String title, List<LT> legend, List<Series> series) {
        return newPieBoard(title, legend).series(series);
    }

    /**
     * 饼图
     * @param name
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Pie newPie(String name, List<T> data) {
        return new Pie().name(name).
                radius("55%").
                center("30%", "60%").data(data.toArray());
    }


    public static <T> Series newLine(String name, List<T> data) {
        return new Line().name(name).data(data.toArray()).
                markPoint(newMarkPoint()).
                markLine(newMarkLine());
    }

    private static MarkLine newMarkLine() {
        return new MarkLine().data(
                new Data().setType(MarkType.average).name("平均值")
        );
    }

    public static MarkPoint newMarkPoint() {
        return new MarkPoint().data(
                new Data().setType(MarkType.max).name("最大值"),
                new Data().setType(MarkType.min).name("最小值")
        );
    }


    public static <LT,T> Option newLineBoard(List<LT> legends, List<T> categoryNames, List<Series> series) {
        return new Option().
                //                title("版权节目采购年统计", "所有节目").
                        tooltip(Trigger.axis).
                        legend(new Legend().data(legends).x("4")).
                        toolbox(new Toolbox().show(true).x("750").
                                feature(
                                        new Mark().show(true)
                                        , new DataView().show(true)
                                        , new MagicType().show(true)
                                        , new Restore().show(true)
                                        , new SaveAsImage().show(true)
                                )).
                        calculable(true).
                        xAxis(new CategoryAxis().data(categoryNames.toArray())).
                        yAxis(new ValueAxis().axisLabel(new AxisLabel().formatter("{value}"))).
                        series(series);
    }


    public static <LT,CT> Option newYValueBarBoard(String title, List<LT> legends, List<CT> categoryNames, List<Series> series) {
        return newBarBoard(title, legends, series).
                xAxis(new CategoryAxis().data(categoryNames.toArray())).
                yAxis(new ValueAxis());
    }

    private static <LT> Option newBarBoard(String title, List<LT> legends, List<Series> series) {
        return new Option().
                title(title).
                tooltip(Trigger.axis).
                legend(legends.toArray()).
                calculable(true).
                toolbox(
                        new Toolbox().show(true).x("750").feature(
                                new Mark().show(true)
                                , new DataView().show(true)
//                                ,new MagicType().show(true).type(new String[]{"bar"})
                                , new Restore().show(true)
                                ,
                                new SaveAsImage().show(true)
                        )).
                series(series);
    }

    public static <LT,CT> Option newXValueBarBoard(String title, List<LT> legends, List<CT> categoryNames, List<Series> series) {
        return newBarBoard(title,legends,series).
                yAxis(new CategoryAxis().data(categoryNames.toArray())).
                xAxis(new ValueAxis());
    }

    public static <T> Series newBar(String name, List<T> data) {
        return new Bar().
                name(name).
                data(data.toArray());
    }

    public static <T> Series newBar(String name, String stack, List<T> data) {
        return new Bar().stack(stack).
                name(name).
                data(data.toArray());
    }

    public static <T> Series newBarAverageLine(String name, String stack, List<T> data) {
        return newBar(name, stack, data).
                markLine(newMarkLine());
    }

    public static <T> Series newBarAverageLine(String name, List<T> data) {
        return newBar(name, data).
                markLine(newMarkLine());
    }
}
