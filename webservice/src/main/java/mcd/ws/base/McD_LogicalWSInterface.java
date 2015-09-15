package mcd.ws.base;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface McD_LogicalWSInterface {

	@WebResult(name="Record")
	public List<String> logicalMethod(@WebParam String Record) throws SQLException, ClassNotFoundException;
	
}
