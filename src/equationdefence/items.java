/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package equationdefence;

/**
 *
 * @author atu3199
 */
public class items {
 private String itemStr;
    private int itemInt;

    items(String itemStr, int itemInt){
        this.itemInt = itemInt;
        this.itemStr = itemStr;
    }

    String returnItemStr(){
        return this.itemStr;
    }

    int returnItemInt(){
        return this.itemInt;
    }
}
