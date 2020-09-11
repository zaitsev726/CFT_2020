package com.example.CFT_2020;

import com.example.CFT_2020.entities.DesktopComputer;
import com.example.CFT_2020.entities.HardDisk;
import com.example.CFT_2020.entities.Monitor;
import com.example.CFT_2020.entities.Notebook;
import com.example.CFT_2020.repositories.DesktopComputerRepo;
import com.example.CFT_2020.repositories.HardDiskRepo;
import com.example.CFT_2020.repositories.MonitorRepo;
import com.example.CFT_2020.repositories.NoteBookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDataBase(DesktopComputerRepo desktopComputerRepo, NoteBookRepo noteBookRepo,
                                   MonitorRepo monitorRepo, HardDiskRepo hardDiskRepo){
        return args ->
        {
            log.info("Rreloading" + desktopComputerRepo.save(new DesktopComputer(167356, "Samsung", 42.5, 25, "Desktop")));
            log.info("Rreloading" + desktopComputerRepo.save(new DesktopComputer(129543, "Apple", 72.5, 13, "Monoblock")));
            log.info("Rreloading" + desktopComputerRepo.save(new DesktopComputer(129545, "Apple", 84.0, 6, "Nettop")));
            log.info("Rreloading" + desktopComputerRepo.save(new DesktopComputer(153990, "Acer", 58.3, 36, "Monoblock")));

            log.info("Rreloading" + noteBookRepo.save(new Notebook(196461, "Asus", 31.0, 1, 13)));
            log.info("Rreloading" + noteBookRepo.save(new Notebook(129649, "Acer", 27.6, 7, 14)));
            log.info("Rreloading" + noteBookRepo.save(new Notebook(181282, "Apple", 67.5, 8, 15)));
            log.info("Rreloading" + noteBookRepo.save(new Notebook(123250, "Samsung", 25.9, 15, 17)));
            log.info("Rreloading" + noteBookRepo.save(new Notebook(134608, "Xiaomi", 54.6, 9, 15)));

            log.info("Rreloading" + monitorRepo.save(new Monitor(123953, "AOC", 36.4, 4, 15.8)));
            log.info("Rreloading" + monitorRepo.save(new Monitor(113356, "Philips", 76.0, 4, 16.7)));
            log.info("Rreloading" + monitorRepo.save(new Monitor(191971, "HP", 94.5, 5, 20.0)));
            log.info("Rreloading" + monitorRepo.save(new Monitor(147607, "Acer", 61.9, 22, 21.4)));

            log.info("Rreloading" + hardDiskRepo.save(new HardDisk(172995, "Seagate", 50.9, 17, 256)));
            log.info("Rreloading" + hardDiskRepo.save(new HardDisk(127858, "WD", 28.0, 1, 128)));
            log.info("Rreloading" + hardDiskRepo.save(new HardDisk(194051, "Seagate", 33.5, 9, 128)));
            log.info("Rreloading" + hardDiskRepo.save(new HardDisk(116807, "Toshiba", 78.3, 9, 1024)));

        };
    }
}
