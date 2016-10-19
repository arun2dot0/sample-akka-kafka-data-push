package akka.kafka.example.datapush.dao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import akka.kafka.example.datapush.avro.schema.EmployeeSchema;
import akka.kafka.example.datapush.dao.Employee;
import akka.kafka.example.datapush.repo.Employeerepository;

import static  com.google.common.base.Strings.*;
@Component
public class MigrationUtil {

	Logger log = Logger.getLogger(MigrationUtil.class.getName());
	@Autowired
	Employeerepository employeeRepository;

	

	public List<EmployeeSchema> copyOutputData(List<Employee> daoDeliveryPref) {
		List<EmployeeSchema> listEmployeeSchema = new ArrayList<EmployeeSchema>();
		daoDeliveryPref.forEach(output -> {
			log.info("DeliveryPreference Conversion " + output.toString());
			listEmployeeSchema.add(new EmployeeSchema(output.getId(), nullToEmpty(output.getFirstName()),
					nullToEmpty(output.getLastName()), nullToEmpty(output.getTitle()),
					checkNullandConvert(output.getCreatedDate()), checkNullandConvert(output.getModifiedDate())));

		});

		return listEmployeeSchema;
	}
	
	private String checkNullandConvert( Date d)
	{
		if (d == null) return "";
		else return d.toString();
	}

	@Transactional
	public void persistOutput(Employee output) {
		Employee outputReturn = employeeRepository.save(output);
		
		log.info(outputReturn.toString());

	}
	

	public Employee findOutput(EmployeeSchema outputData) {
		return employeeRepository.findOne(outputData.getId());
	}

}
