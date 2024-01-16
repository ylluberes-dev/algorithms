package com.codility;

import java.util.Optional;
import java.util.stream.Stream;

public class ProductionLineTester {

    private final ProductVerifier verifier;

    ProductionLineTester(ProductVerifier verifier) {
        this.verifier = verifier;
    }

    ProductLineTestReport test(Stream<Product> products) {

        ProductLineTestReport report =
                new ProductLineTestReport(0, 0, 0, 0);
        if(products != null && products.findAny().isPresent()) {
            products.filter(product -> product != null
                    && "invalid"
                    .equalsIgnoreCase(product.getStatus()))
                    .skip(10).limit(20)
                    .forEach(product -> {
                        try {
                            verifier.verify(product);
                            report.correctCnt++;
                        } catch (Throwable th) {
                            if (th instanceof Exception) {
                                report.checkedExcCnt++;
                            } else if (th instanceof RuntimeException) {
                                report.uncheckedExcCnt++;
                            } else if (th instanceof Error) {
                                report.otherExcCnt++;
                            }
                        }
                    });
        }
        return report;
    }

    interface ProductVerifier {
        void verify(Product product) throws Exception;
    }

    class ProductLineTestReport {
        long correctCnt;      // number of correct products
        long checkedExcCnt;   // number of products which threw a checked exception during verification
        long uncheckedExcCnt; // number of products which threw an unchecked exception during verification
        long otherExcCnt;     // number of products which threw an error during verification

        ProductLineTestReport(long correctCnt, long checkedExcCnt, long uncheckedExcCnt, long otherExcCnt) {
            this.correctCnt = correctCnt;
            this.checkedExcCnt = checkedExcCnt;
            this.uncheckedExcCnt = uncheckedExcCnt;
            this.otherExcCnt = otherExcCnt;
        }
    }

    class Product {
        private String status;

        public String getStatus() {
            return status;
        }

        public Product(String status) {
            this.status = status;
        }
    }
}
