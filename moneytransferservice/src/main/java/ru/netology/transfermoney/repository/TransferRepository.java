package ru.netology.transfermoney.repository;

import org.springframework.stereotype.Repository;
import ru.netology.transfermoney.model.TransferRequest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class TransferRepository {
    private final Map<String, TransferRequest> transfers = new ConcurrentHashMap<>();
    private final Map<String, String> codes = new ConcurrentHashMap<>();
    private final AtomicInteger operationId = new AtomicInteger();

    public int getOperationId() {
        return operationId.incrementAndGet();
    }

    public void addTransfer(String id, TransferRequest transferRequest) {
        transfers.put(id, transferRequest);
    }

    public void addCode(String id, String code) {
        codes.put(id, code);
    }

    public TransferRequest removeTransfer(String id) {
        return transfers.remove(id);
    }

    public String removeCode(String id) {
        return codes.remove(id);
    }

}
