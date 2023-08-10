package pe.todotic.demotasks_ec2rds.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.demotasks_ec2rds.modelo.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}

