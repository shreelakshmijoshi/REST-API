package com.springrest.SpringAPI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.SpringAPI.dao.LoadDao;
import com.springrest.SpringAPI.entities.Load;
/*
 * @Service tells SpringBoot FrameWork that this LoadService interface is working 
 * in Service Layer of J2EE Architecture
 *
 */
@Service
public class LoadServiceImplementation implements LoadService{

//	List<Load> list1;
	
	@Autowired
	private LoadDao loadDoaObject;
	
//	public Load(long shipperId, String loadingPoint, String unloadingPoint, String productType, String truckType,
//			int noOfTrucks, int weight, String optional, String date) {
	public LoadServiceImplementation()
	{
//		list1 = new ArrayList<>();
//		list1.add(new Load(145, "delhi","jaipur", "chemicals", "canter", 1, 100, "comment : ", "dd-mm-yyyy" ));
//		list1.add(new Load(262, "alwar","jaipur", "chemicals", "canter", 1, 100, "comment : ", "dd-mm-yyyy" ));
	
	}
	
	@Override
	public List<Load> getLoad() {
		// TODO Auto-generated method stub
//		return list1;
		return loadDoaObject.findAll();
	}

	@Override
	public Optional<Load> getLoad(long id) {
		// TODO Auto-generated method stub
//		Load temp = null;
//		for(Load x : list1)
//		{
//			if(x.getShipperId() == id)
//			{
//				temp = x;
//				break;
//			}
//		}
//		return temp;
		return loadDoaObject.findById(id);
	}

	@Override
	public Load addLoad(Load loadObject)
	{
//		list1.add(loadObject);
//		return loadObject;
		
		loadDoaObject.save(loadObject);
		return loadObject;
	}
	
	@Override
	public Load updateLoad(Load loadObject)
	{
//		list1.forEach(e -> {
//			if(e.getShipperId() == loadObject.getShipperId()) {
//				e.setDate(loadObject.getDate());
//				e.setLoadingPoint(loadObject.getLoadingPoint());
//				e.setNoOfTrucks(loadObject.getNoOfTrucks());
//				e.setOptional(loadObject.getOptional());
//				e.setProductType(loadObject.getProductType());
//				e.setTruckType(loadObject.getTruckType());
//				e.setUnloadingPoint(loadObject.getUnloadingPoint());
//				e.setWeight(loadObject.getWeight());
//			}
//		});
//		return loadObject;
		loadDoaObject.save(loadObject);
		return loadObject;
	}
	
	@Override
	public void deleteLoad(long id)
	{
//		list1 = this.list1.stream().filter(e -> e.getShipperId() != id).collect(Collectors.toList());
		Load entity = loadDoaObject.getById(id);
		loadDoaObject.delete(entity);
		
	}
}
