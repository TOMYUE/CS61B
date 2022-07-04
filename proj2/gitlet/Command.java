package gitlet;
import java.io.*;
import java.util.*;

/**
 * @Author TOMYUE
 * @Date 2022/7/4
 */
public class Command {
    /* init command */
    static void init() throws IOException{
        Repository.setPersistence();
    }
}
