package by.vsu.ist.repository;

import by.vsu.ist.domain.Transfer;

import java.util.List;

public interface TransferRepository extends Repository<Transfer> {
	List<Transfer> readByAccount(Long accountId) throws RepositoryException;
}
