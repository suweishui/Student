
import java.util.Scanner;


/**
 * @author 17586
 */
public class Test {
    public static void demo(int i){
        int x = 1;
        int y = 0;
        int z = 0;
        int count = 1;
        while (i>0){
            z = x + y;
            if(count>=2){

                y = x;
                x = z;
            }
            System.out.println(z);
            count++;
            i--;
        }
    }
    public static String feiji(/*装参数*/){
        //用户输入
        Scanner input=new Scanner(System.in);
        System.out.println("请输入周———");
        String a=input.next();
        //主方法授权
        return switch (a) {
            case "一" -> "谈恋爱";
            case "二" -> "结婚";
            case "三" -> "搞基";
            case "四" -> "打飞机";
            default -> "test";
        };
    }
    public static void main(String[] args){
       /* String c=feiji();
        System.out.println(c);*/
        //demo(20);
    }
  /*  public static void main(String[] args) {
        String sql ="select * from reader";
        ResultSet rs = JdbcHelper.executeQuery(sql,null);
        List<Reader> list = new ArrayList<>();
        Reader reader = null;
        try {
            if (rs != null) {
                while (rs.next()) {
                    reader = new Reader(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getString(5),
                            rs.getString(6), rs.getString(7));
                    list.add(reader);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            JdbcHelper.release(JdbcHelper.conn,JdbcHelper.ps,rs);
        }
        for(Reader reader1:list){
            System.out.println(reader1);
        }
    }*/
}
