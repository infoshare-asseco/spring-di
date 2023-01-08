package pl.infoshare.springdi.claims.model;

import lombok.Value;

@Value
public class ClaimEligibility {
    boolean eligible;
    ClaimRegulation regulation;

    public static ClaimEligibility ineligibile() {
        return new ClaimEligibility(false, null);
    }

    public static ClaimEligibility forRegulation(ClaimRegulation regulation) {
        if (regulation == ClaimRegulation.NONE) {
            return ineligibile();
        }
        return new ClaimEligibility(true, regulation);
    }
}
