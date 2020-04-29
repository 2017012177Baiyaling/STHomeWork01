package com.servlet.person;

public @interface WebServlet {

	String name();

	String urlPatterns();

	boolean asyncSupported();

}
