package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class GildedRoseApprovalTest {

    @Test
    void update_quality_for_thirty_one_days() {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Program.main();

        Approvals.verify(outputStream.toString());
    }
}
