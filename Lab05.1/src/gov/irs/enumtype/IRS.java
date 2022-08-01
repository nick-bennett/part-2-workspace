package gov.irs.enumtype;

import gov.irs.TaxPayer;

public interface IRS {

  void collectTaxes();

  void register(TaxPayer payer);

  static IRS getInstance() {
    return IRSEnum.INSTANCE;
  }

}
