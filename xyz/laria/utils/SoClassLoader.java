package xyz.laria.utils;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

public class SoClassLoader extends URLClassLoader {
    public HashMap overrides = new HashMap();

    public SoClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    protected Class findClass(String name) throws ClassNotFoundException {
        return this.overrides.containsKey(name) ? (Class)this.overrides.get(name) : super.findClass(name);
    }
}
