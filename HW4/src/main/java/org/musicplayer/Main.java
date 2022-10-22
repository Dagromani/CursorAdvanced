package org.musicplayer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        MusicPlayerService rockPlayer = context.getBean("rockPlayer" , MusicPlayerService.class);
        rockPlayer.playRock();
        System.out.println("");

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-factory.xml");
        MusicPlayerService player = (MusicPlayerService) beanFactory.getBean("player");
        player.playClassic();
        System.out.println("");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        MusicPlayerService rockPlayerNo2 = (MusicPlayerService) applicationContext.getBean("rockPlayer");
        rockPlayerNo2.playRock();
    }
}
