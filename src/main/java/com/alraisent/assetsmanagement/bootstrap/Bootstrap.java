//package com.alraisent.assetsmanagement.bootstrap;
//
//import com.alraisent.assetsmanagement.entity.Asset;
//import com.alraisent.assetsmanagement.entity.Location;
//import com.alraisent.assetsmanagement.entity.Model;
//import com.alraisent.assetsmanagement.entity.Status;
//import com.alraisent.assetsmanagement.repository.AssetRepository;
//import com.alraisent.assetsmanagement.repository.LocationRepository;
//import com.alraisent.assetsmanagement.repository.ModelRepository;
//import com.alraisent.assetsmanagement.repository.StatusRepository;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
//
//    private final AssetRepository assetRepository;
//    private final ModelRepository modelRepository;
//    private final LocationRepository locationRepository;
//    private final StatusRepository statusRepository;
//
//
//    public Bootstrap(AssetRepository assetRepository, ModelRepository modelRepository, LocationRepository locationRepository, StatusRepository statusRepository) {
//        this.assetRepository = assetRepository;
//        this.modelRepository = modelRepository;
//        this.locationRepository = locationRepository;
//        this.statusRepository = statusRepository;
//    }
//
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        Model model = new Model();
//        Status status = new Status();
//        Location location = new Location();
//
//        status.setDescription("Deployed");
//
//        location.setAddress("al warsan dubai uae");
//        location.setCity("Dubai");
//        location.setName("ATH-Al Warsan");
//
//        model.setName("DELL");
//        model.setModelNumber("54534");
//
//
//        locationRepository.save(location);
//        statusRepository.save(status);
//        modelRepository.save(model);
//
////        assetRepository.saveAll(loadAssets());
//    }
//
//    private List<Asset> loadAssets() {
//
//        List<Asset> assets = new ArrayList<>();
//
//        Asset laptop = new Asset();
//
//
////        laptop.setAssetTag("LPT-100001");
////        laptop.setName("Dell Inspiron 2020");
////        laptop.setModel(model);
////        laptop.setStatus(status);
////        laptop.setLocation(location);
////        laptop.setSerial("asdlj12903");
//
//
//        assets.add(laptop);
//
//        return assets;
//    }
//}
