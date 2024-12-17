package by.vsu.ist.repository;

public interface TransactionManager {
	void startTransaction() throws RepositoryException;

	void commitTransaction() throws RepositoryException;

	void rollbackTransaction() throws RepositoryException;
}
