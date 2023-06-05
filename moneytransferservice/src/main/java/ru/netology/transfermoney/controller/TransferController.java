package ru.netology.transfermoney.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.transfermoney.exceptions.InputDataException;
import ru.netology.transfermoney.model.ConfirmOperationRequest;
import ru.netology.transfermoney.model.TransferResponse;
import ru.netology.transfermoney.model.TransferRequest;
import ru.netology.transfermoney.service.TransferService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
public class TransferController {
    private final TransferService service;

    @PostMapping("/transfer")
    public TransferResponse transfer(@RequestBody TransferRequest transferRequest) {
        return service.transfer(transferRequest);
    }

    @PostMapping("/confirmOperation")
    public TransferResponse confirmOperation(@RequestBody ConfirmOperationRequest confirmOperationRequest) {
        return service.confirmOperation(confirmOperationRequest);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InputDataException.class)
    public String HandlerInvalidCredentials (InputDataException ex) {
        return ex.getMessage();
    }

}
