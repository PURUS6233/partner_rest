package ua.partner.suzuki.services.resources;

import java.util.Collection;
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

import ua.partner.suzuki.dao.DAOException;
import ua.partner.suzuki.domain.DomainException;
import ua.partner.suzuki.domain.obm.OBM;
import ua.partner.suzuki.service.EngineNumbersLoaderService;
import ua.partner.suzuki.service.ServiceException;
import ua.partner.suzuki.service.WarehouseService;
import ua.partner.suzuki.service.impl.EngineNumbersLoaderServiceImpl;
import ua.partner.suzuki.service.impl.WarehouseServiceImpl;

@Path("/obms")
public class OBMResource {
	
	private WarehouseService service = new WarehouseServiceImpl();
	private EngineNumbersLoaderService loaderService = new EngineNumbersLoaderServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<OBM> getAllOBMs() throws ServiceException {
        return service.getAll();
    }
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_XML)
    public Collection<OBM> addOBMs(String engineNumbers) throws ServiceException, DomainException, DAOException{
    	loaderService.saveToFile(engineNumbers);
    	return service.add(engineNumbers);
    }
    
    @PUT
    @Path("/{engineNumber}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public OBM updateOBM(@PathParam("engineNumber") String engineNumber, OBM obm) throws ServiceException{
    	obm.setEngineNumber(engineNumber);
    	return service.update(obm);
    }
    
    @DELETE
    @Path("/{engineNumber}")
    @Produces(MediaType.APPLICATION_XML)
    public OBM deleteOBM(@PathParam("engineNumber") String engineNumber) throws ServiceException{
    	return service.remove(engineNumber);
    }
    
    @Path("/{engineNumber}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public OBM getOBM(@PathParam("engineNumber") String engineNumber) throws ServiceException {
    	return service.get(engineNumber);
    }
}
