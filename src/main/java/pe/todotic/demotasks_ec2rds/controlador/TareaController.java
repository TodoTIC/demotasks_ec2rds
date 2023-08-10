package pe.todotic.demotasks_ec2rds.controlador;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.todotic.demotasks_ec2rds.modelo.Tarea;
import pe.todotic.demotasks_ec2rds.repositorio.TareaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@AllArgsConstructor
public class TareaController {

    private TareaRepository tareaRepository;

    @GetMapping
    public List<Tarea> listar() {
        return tareaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tarea obtener(@PathVariable Integer id) {
        return tareaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Tarea crear(@RequestBody @Validated Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizar(
            @PathVariable Integer id,
            @RequestBody @Validated Tarea form
    ) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        tarea.setTitulo(form.getTitulo());
        return tareaRepository.save(tarea);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        tareaRepository.delete(tarea);
    }

}
