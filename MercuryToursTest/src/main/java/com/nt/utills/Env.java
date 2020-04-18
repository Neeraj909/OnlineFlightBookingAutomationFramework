package com.nt.utills;

public class Env {

	 private Config Config;

	    public Config getConfig ()
	    {
	        return Config;
	    }

	    public void setConfig (Config Config)
	    {
	        this.Config = Config;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [Config = "+Config+"]";
	    
	    }
}
