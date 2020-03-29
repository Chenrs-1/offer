import org.junit.Test;

import java.nio.ByteBuffer;

public class NIo_learn {

    @Test
    public void test1(){
        //1.分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
    }

}
