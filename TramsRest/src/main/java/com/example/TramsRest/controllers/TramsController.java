package com.example.TramsRest.controllers;

import com.example.TramsRest.models.Tram;
import com.example.TramsRest.service.TramsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("/trams")
public class TramsController {
    /**
     * Инкапсулируем сервис-интерфейс для работы с БД
     */
    private final TramsService tramsService;

    /**
     * Получение всех маршрутов
     *
     * @return список всех маршрутов
     */
    @GetMapping
    public ResponseEntity<List<Tram>> getAllTrams() {
        return new ResponseEntity<>(tramsService.getAllTrams(), HttpStatus.OK);
    }

    /**
     * Получить маршрут по уникальному идентификатору
     *
     * @param id идентификатор маршрута
     * @return искомый маршрут
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tram> getById(@PathVariable("id") int id) {
        return new ResponseEntity<>(tramsService.getTramById(id), HttpStatus.OK);
    }

    /**
     * Создание нового маршрута
     *
     * @param tram маршрут из тела запроса
     * @return созданный маршрут
     */
    @PostMapping
    public ResponseEntity<Tram> createTram(@RequestBody Tram tram) {
        return new ResponseEntity<>(tramsService.createTrams(tram), HttpStatus.CREATED);
    }

    /**
     * Удаление маршрута
     *
     * @param id уникальный идентификатор маршрута
     * @return статус выполнения запроса
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delTram(@PathVariable("id") int id) {
        tramsService.deleteTramById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Обновление маршрута
     *
     * @param id          уникальный идентификатор машрута
     * @param tramDetails передаваемые данные для обновления из тела запроса
     * @return обновленный маршрут
     */
    @PutMapping("{id}")
    public ResponseEntity<Tram> updateTram(@PathVariable("id") int id, @RequestBody Tram tramDetails) {
        Tram tram = tramsService.updateTramById(id, tramDetails);
        return new ResponseEntity<>(tram, HttpStatus.OK);
    }

}
