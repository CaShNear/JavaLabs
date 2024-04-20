package org.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main {

    public static void main( String[] args )
    {

        SparkSession spark = SparkSession.builder()
                .appName("Ramen Rating")
                .master("local[*]")
                .getOrCreate();

        spark.sparkContext().setLogLevel("ERROR");

        Dataset<Row> dataset = spark.read().format("csv")
                .option("header", "true")
                .load("ramen-ratings.csv");
        dataset.createOrReplaceTempView("ramen_rate");

        System.out.println("1. All dataset:");
        spark.sql("select * from ramen_rate").show();

        System.out.println("2. Count of ramen's brand:");
        spark.sql("select count(distinct Brand) as BrandCount from ramen_rate").show();

        System.out.println("3. All ramen from Japan with kimchi:");
        spark.sql("select Brand, Variety, Style, Stars from ramen_rate where Country = 'Japan' and Variety like '%Kimchi%'").show();

        System.out.println("4. Average stars rate of all ramen:");
        spark.sql("select avg(Stars) as StarsAvg from ramen_rate").show();

        System.out.println("5. All Nissin ramen with rate above 4:");
        spark.sql("select Variety, Style, Country, Stars from ramen_rate where Brand = 'Nissin' and Stars >= 4 order by Stars asc").show();

        System.out.println("6. All not Nissin ramen from USA with rate equal 5:");
        spark.sql("select Brand, Variety, Style from ramen_rate where Brand <> 'Nissin' and Stars = 5 and Country = 'USA'").show();

        System.out.println("7. Percent of pack, bowl, cup and other types of ramen's style:");
        spark.sql("select PackAmount*100/TotalAmount as PackPercent, BowlAmount*100/TotalAmount as BowlPercent, " +
                "CupAmount*100/TotalAmount as CupPercent, 100-(PackAmount+BowlAmount+CupAmount)*100/TotalAmount as OtherPercent from " +
                "(select sum(case when Style = 'Pack' then 1 else 0 end) as PackAmount, " +
                "sum(case when Style = 'Bowl' then 1 else 0 end) as BowlAmount, " +
                "sum(case when Style = 'Cup' then 1 else 0 end) as CupAmount, " +
                "count(*) as TotalAmount from ramen_rate) as RR").show();

        System.out.println("8. Other types of ramen's style except pack, cup and bowl:");
        spark.sql("select distinct Style as OtherStyles from ramen_rate where Style not in ('Pack', 'Bowl', 'Cup')").show();

        System.out.println("9. Average rate of ramen by brands:");
        spark.sql("select Brand, avg(Stars) as StarsAvg from ramen_rate group by Brand order by StarsAvg desc").show();

        System.out.println("10. Counts of brands in each country:");
        spark.sql("select Country, count(Brand) as BrandCount from ramen_rate group by Country").show();

        spark.stop();

    }

}
