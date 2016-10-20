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

import ua.partner.suzuki.domain.dealer.Dealer;
import ua.partner.suzuki.service.DealerService;
import ua.partner.suzuki.service.ServiceException;
import ua.partner.suzuki.service.impl.DealerServiceImpl;

@Path("/dealers")
public class DealerResource {

	private DealerService service = new DealerServiceImpl();

	@Path("/{dealerLogin}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Dealer getDealer(@PathParam("dealerLogin") String dealerLogin)
			throws ServiceException {
		return service.get(dealerLogin);
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Dealer> getAllDealers() throws ServiceException {
		return service.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Dealer addDealer(Dealer dealer)
			throws ServiceException {
		return service.add(dealer);
	}

	@PUT
	@Path("/{dealerLogin}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Dealer updateDealer(@PathParam("dealerLogin") String login, Dealer dealer)
			throws ServiceException {
		dealer.setLogin(login);
		return service.update(dealer);
	}

	@DELETE
	@Path("/{dealerLogin}")
	@Produces(MediaType.APPLICATION_XML)
	public Dealer deleteDealer(@PathParam("dealerLogin") String dealerLogin)
			throws ServiceException {
		return service.remove(dealerLogin);
	}
}
