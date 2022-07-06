package gitlet;

import java.io.IOException;
import java.sql.SQLOutput;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TOMYUE
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        /* When args count is less than one. */
        if(args.length < 1){
            System.out.println("Please enter a command.");
            System.exit(0);
        }

        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: handle the `init` command
                /* create a hidden file as local repo. */
                validateNumArgs("init", args, 1);
                try{
                    Repository.init();
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case "add":
                // TODO: handle the `add [filename]` command
                validateNumArgs("add", args, 2);

                break;
            case "commit":
                //TODO: handle the 'commit -m "msg"' command
                break;
            case "rm":
                //TODO: handle the 'rm' command
                break;
            case "log":
                //TODO: handle the 'log' command
                break;
            case "global-log":
                //TODO: handle the 'git-log' command
                break;
            case "find":
                //TODO: handle the 'find' command
                break;
            case "status":
                //TODO: handle the 'status' command
                break;
            case "checkout":
                //TODO: handle the 'checkout' command
                break;
            case "branch":
               //TODO: handle the 'branch' command
                break;
            case "rm-branch":
                //TODO: handle the 'rm-branch' command
                break;
            case "reset":
                //TODO: handle the 'reset' command
                break;
            case "merge":
                //TODO: handle the 'merge' command
                break;
            default:
                System.out.println("No command with that name exists.");
                System.exit(0);
        }
    }

    public static void validateNumArgs(String cmd, String[] args, int n) {
        if(args.length != n){
            System.out.println("Incorrect operands.");
        }
    }

}
