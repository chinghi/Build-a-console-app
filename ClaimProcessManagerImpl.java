import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleFunction;

class ClaimProcessManagerImpl implements ClaimProcessManager {
    private final List<Claim> claims = new ArrayList<>();

    @Override
    public void add(Claim claim) {
        claims.add(claim);
    }

    @Override
    public void update(Claim claim) {
        // Implement update operation
    }

    @Override
    public void delete(String id) {
        // Implement delete operation
    }

    @Override
    public Claim getOne(String id) {
        // Implement getOne operation
        return null;
    }

    @Override
    public List<Claim> getAll() {
        return new ArrayList<>(claims);
    }

    @Override
    public List<Claim> getAllSortedByAmount() {
        List<Claim> sortedClaims = new ArrayList<>(claims);
        sortedClaims.sort(Comparator.comparingDouble((ToDoubleFunction<? super Claim>) claim -> (double) claim.getClaimAmount()));
        return sortedClaims;
    }
}