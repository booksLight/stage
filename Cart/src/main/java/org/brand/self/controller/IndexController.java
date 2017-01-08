package org.brand.self.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

	@RequestMapping("/appointments")
	public String index(){
		System.out.println("\n ******** Controller +++++");
		return "home";
	}
	/*
	private final AppointmentBook appointmentBook;

    @Autowired
    public AppointmentsController(AppointmentBook appointmentBook) {
        this.appointmentBook = appointmentBook;
    }
    
	 @RequestMapping(path = "/{day}", method = RequestMethod.GET)
	    public Map<String, Appointment> getForDay(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day, Model model) {
	        return appointmentBook.getAppointmentsForDay(day);
	    }
	 
	 @RequestMapping(path = "/new", method = RequestMethod.GET)
	    public AppointmentForm getNewForm() {
	        return new AppointmentForm();
	    }
	 
	 @RequestMapping(method = RequestMethod.POST)
	    public String add(@Valid AppointmentForm appointment, BindingResult result) {
	        if (result.hasErrors()) {
	            return "appointments/new";
	        }
	        appointmentBook.addAppointment(appointment);
	        return "redirect:/appointments";
	    }*/
}
