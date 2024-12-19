package tp.bestioles.demo.bll;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CronService {

    // Récupération de l'intervalle depuis le fichier application.properties
    @Value("${cron.task.schedule}")
    private String cronExpression;

    // Méthode planifiée pour s'exécuter toutes les 30 secondes
    @Scheduled(cron = "${cron.task.schedule}")
    public void printCurrentDate() {
        // Affiche la date/heure actuelle
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("Current date and time: " + currentDate);
    }
}
