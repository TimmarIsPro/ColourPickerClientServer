/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourpicker;

import java.io.*;
/**
 *
 * @author J380446
 */
public class Colour implements Serializable {
    String name, hex, rgba;
    
    Colour(String n, String h, String r)
    {
        this.name = n;
        this.hex = h;
        this.rgba = r;
    }
}
