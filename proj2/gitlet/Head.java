package gitlet;

/**
 * @Author TOMYUE
 * @Date 2022/7/6
 */

import java.io.File;
import java.io.Serializable;

/**
 *
 * */
public class Head implements Serializable {
    private String hashValue;
    private String branch;

    public Head(String hashValue, String branchName){
        this.hashValue = hashValue;
        this.branch = branchName;
    }

    /* Get the hashValue. */
    public String getHeadHashValue() {
        return this.hashValue;
    }

    /* Get the branch name. */
    public String getHeadBranchName() {
        return this.branch;
    }

    /* Save Head to file. */
    public void storeHeadToFile() {
        File pathName = new File(Repository.HEAD + "/" + this.branch);
        Utils.writeContents(pathName, this);
    }

    /* Read Head from file. */
    public Head readFromFile(File file) {
        return Utils.readObject(file, Head.class);
    }
}
