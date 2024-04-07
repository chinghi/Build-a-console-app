import java.util.List;

interface ClaimProcessManager {
    void add(Claim claim);

    void update(Claim claim);

    void delete(String id);

    Claim getOne(String id);

    List<Claim> getAll();

    List<Claim> getAllSortedByAmount();
}
