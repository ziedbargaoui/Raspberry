package com.raspberry.servlets;

import java.io.PrintWriter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinDirection;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.io.gpio.trigger.GpioPulseStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.event.PinEventType;


/**
 * Servlet implementation class Heat
 */
@WebServlet("/Heat")
public class Heat extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String currentTemperature;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Heat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Here you need to get the current temperature from the Raspberry Pi 
		
		response.getWriter().append("Current Temperature: "+ currentTemperature );
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

        String heatDegree = request.getParameter("heatDegree");
        

		// TODO Here you need to set the temperature of the Raspberry Pi 
        
        currentTemperature = heatDegree;
        
		try {
			// create gpio controller instance
			final GpioController gpio = GpioFactory.getInstance();
			
		} catch (UnsatisfiedLinkError e) {
			// TODO: handle exception
	        System.err.println("platform does not support this driver");      
	        
	    } catch (Exception e) {
			// TODO: handle exception
	        System.err.println("platform does not support this driver");      
		}

        out.print("You are successfully registered...");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		out.close();
	}

}
