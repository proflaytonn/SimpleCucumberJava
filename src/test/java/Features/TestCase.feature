Feature: Submit Sales Order Virtual to Refund
  @Refund
  Scenario Outline: Submit Sales Order to Refund through Sales Order Cancel
    Given Login to CMS Virtual "put URL https://xxx" with email "put username" and password "put password"
    When Go to Sales Order Cancel page
    And Do the date filter
    And Search "<SalesOrder>" and Click the detail
    And Submit the refund
    Then Appear wording "<SalesOrder>" that "has been set to Refund"

    Examples:
      | SalesOrder |
      | AXXXXXXXX  |

  @RegressionCMSRefund
  Scenario: Regression of CMS Virtual-Sales Cancel
    Given Login to CMS Virtual "put URL https://xxx" with email "put username" and password "put password"
    When Go to Sales Order Cancel page
    And Do the date filter
    And Search "AXXXXXXXX" and Click the detail
    Then Check if SOC Detail opened successfuly

  @RegressionCMSRefund @Test
  Scenario: Regression of CMS Virtual-Berita Acara Refund
    Given Login to CMS Virtual "put URL https://xxx" with email "put username" and password "put password"
    When Go to Berita Acara Refund Page
    And Do the date filter
    And Click the BA filter button
    And Open the BA Refund Detail
    Then BA Refund Detail successfuly opened

  @RegressionCMSRefund
  Scenario: Regression of CMS Virtual-Berita Acara Refund Filter
    Given Login to CMS Virtual "put URL https://xxx" with email "put username" and password "put password"
    When Go to Berita Acara Refund Page
    And Click the more criteria filter
    And Check the "Status" from Criteria Filter
    And Click the Status Filter
    And Choose status "Finish" filter from Status Filter
    And Click the BA filter button
    Then SalesOrder with finish status appear