package ua.partner.suzuki.services.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ua.partner.suzuki.domain.customer.Customer;
import ua.partner.suzuki.service.CustomerService;
import ua.partner.suzuki.service.ServiceException;
import ua.partner.suzuki.service.impl.CustomerServiceImpl;

@Path("/customers")
public class CustomerResource {

	private CustomerService service = new CustomerServiceImpl();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Customer> getAllCustomers() throws ServiceException {
		return service.getAll();
	}

	@Path("/{engineNumber}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomer(@PathParam("engineNumber") String engineNumber)
			throws ServiceException {
		return service.get(engineNumber);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Customer addCustomer(Customer customer) throws ServiceException {
		return service.add(customer);
	}

	@PUT
	@Path("/{engineNumber}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Customer updateCustomer(@PathParam("engineNumber") String engineNumber,
			Customer customer) throws ServiceException {
		customer.setEngineNumber(engineNumber);
		return service.update(customer);
	}

	@DELETE
	@Path("/{engineNumber}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer deleteCustomer(@PathParam("engineNumber") String engineNumber)
			throws ServiceException {
		return service.remove(engineNumber);
	}

}
