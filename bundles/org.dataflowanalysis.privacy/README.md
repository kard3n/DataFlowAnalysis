# Privacy Violation Detection
To run the analysis, execute the `PrivacyDFDAnalysisCLI.java` class located inside the `org.dataflowanalysis.privacy.interactive` package.

## Dos and Don'ts
### Don't:
Change the following logic inside the PrivacyDFDTransposeFlowGraphFinder:
* For user nodes, the original one is replicated for each user except the last one, for which the original node is modified instead.
* Pins receive unique names, even if this should not affect the logic of the application.

Why: This was a fix for a bug which only manifested in the OnlineShop case study. Specifically, the outgoing flows of the Customer node displayed incorrect behavior where if the data from their input pins was forwarded depended on multiple factors: When multiple output pins $p$ of a Behavior A have flows which go into the same destination pin $p_1$, then any assignment that forwards data into any of $p$ will bug out all other assignments with a flow which goes from the same node to the same input pin and node of another node.. This only bugs out pins that also have labels forwarded into them (via Assignment or ForwardAssignment).
