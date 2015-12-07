import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Created by yejiapc on 15/12/7.
 */

//Mp3Filter实现FilenameFilter接口，重写accept方法
public class Mp3Filter implements FilenameFilter{

    String extension = ".";

    public Mp3Filter(String extensionName){
        extension += extensionName;
    }

    @Override
    public boolean accept(File file, String s) {
        return s.endsWith(extension);
    }

    public static void main(String[] args){
        getFiles("mp3root");
    }

    //    通过递归得到指定路径下所有的目录及文件
    private static void getFiles(String path){
        //        指定目录
        File directory = new File(path);
        //        列出所有文件
        File[] files = directory.listFiles();
        //        列出当前目录下的mp3文件
        filterMp3(directory);

        for(File file:files){
            //        如果是文件夹，继续遍历目录
            if(file.isDirectory()){
                getFiles(file.getAbsolutePath());
            }
        }
    }

    //        列出所有mp3文件
    private static void filterMp3(File directory){
        File[] mp3Files = directory.listFiles(new Mp3Filter("mp3"));

        for(File file:mp3Files){
            System.out.println("目录"+directory.getName()+"下的mp3文件: "+file.getName());
        }
    }
}