/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arhs.team1100.ultimateascent.util;

import java.util.Vector;

/**
 *
 * @author Akshay
 */
public class Log {

    public final static int LEVEL_DEBUG = 0;
    public final static int LEVEL_WARN = 1;
    public final static int LEVEL_ERROR = 2;
    public final static int LEVEL_OFF = 3;
    private static int maxLevel;
    private static Vector classes;

    public static void init() {
        classes = new Vector();
        maxLevel = LEVEL_DEBUG;
    }

    public static void setMaxLevel(int mlvl) {
        maxLevel = mlvl;
    }

    public static void addClass(Class c, int level) {
        classes.addElement(new LogClass(c, level));
    }

    public static void log(Object source, String message, int level) {
        LogClass lc = null;
        for (int i = 0; i < classes.size(); i++) {
            if (classes.elementAt(i).equals(source.getClass())) {
                lc = (LogClass) classes.elementAt(i);
            }
        }
        if (lc == null) {
            return;
        }
        if (level >= lc.maxLevel && level >= maxLevel) {
            System.out.println("[" + lc.mClass.getName().substring(lc.mClass.getName().lastIndexOf('.')) + "] " + message);
        }
    }
}

class LogClass {

    public Class mClass;
    public int maxLevel;

    public LogClass(Class c, int l) {
        mClass = c;
        maxLevel = l;
    }

    public boolean equals(Object c) {
        return c == mClass;
    }
}
