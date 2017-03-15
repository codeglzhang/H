package com.H.Controller;

import com.H.Modle.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dell on 2017/3/13.
 */
public interface LoggerRepository extends JpaRepository<Logger,String> {
    Logger findByName(String name);
}
