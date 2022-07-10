package gitlet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author TOMYUE
 * @Date 2022/7/6
 */
public class StagingArea implements Serializable {
    private HashMap<String, String> addedFiles;
    private ArrayList<String> removedFiles;

    public StagingArea() {

    }
}
