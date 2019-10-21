import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jc6t on 2015/3/19.
 */
public class BufferChannel {

    public static void main(String[] args) throws IOException {
        /**
         * try read file by FileChannel and add some Chinese into it.
         */
//        System.out.println(BufferChannel.class.getResource("/").getPath());
        File file=new File(BufferChannel.class.getResource("/").getPath()+"test.txt");
        File outputFile=new File(BufferChannel.class.getResource("/").getPath()+"output.txt");
        if(!outputFile.exists()){
            if(outputFile.createNewFile()){
                System.out.println("wrong");
            }
        }
        FileChannel inChannel=new FileInputStream(file).getChannel();
        FileChannel outChannel=new FileOutputStream(outputFile).getChannel();
        ByteBuffer buf=ByteBuffer.allocate(1024);
        byte[] bytes=null;

        int isRead=inChannel.read(buf); //read into buffer.
        while(isRead!=-1){
            buf.flip(); //make buffer ready for read
            bytes=new byte[buf.limit()];
            buf.get(bytes);
            buf.clear();
            isRead=inChannel.read(buf);
        }
        outChannel.write(buf);

        outChannel.force(true);
        inChannel.close();
        outChannel.close();
//        FileChannel inChannel=new FileInputStream()
//        File file=new File();
//        FileInputStream file=
    }
}
