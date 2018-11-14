/* 
    John Kurt Turner
    Nov 13th 2018
    Demo on how to interact with Sqlite lib
*/

/* 
Example on how to run with a jar file in your class path
D:\work\ciss301\SqlLite>javac ManagePeople.java
D:\work\ciss301\SqlLite>java -classpath ".;sqlite-jdbc-3.20.0.jar" ManagePeople
*/

public class ManagePeople{
    UsersDB UDB = new UsersDB();

    public static void main(String[] args) {
        new ManagePeople();
    }
    
    public ManagePeople(){ 
        UDB.connectDB();
        UDB.createTable();
        UDB.addDataToPeopleTable("Bob", 43, "123 Any St.", "Cleveland", "TN", "37320", 43000.25);
        UDB.addDataToPeopleTable("Sandy", 25, "400 North Lee Hwy", "Cleveland", "TN", "37317", 16700.12);
        UDB.addDataToPeopleTable("April", 49, "10 You Know It Drive", "Greensboro", "NC", "27012", 82000.00);
    }

}
