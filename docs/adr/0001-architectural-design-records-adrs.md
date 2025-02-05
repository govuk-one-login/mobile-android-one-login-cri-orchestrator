# Storing Architectural Design Records (ADRs)

<!-- vale Google.We = NO -->

## Summary

An Architectural Decision Record (ADR) is a record of a design choice that's architecturally significant.

We can store ADRs within the `/docs` folder of this repository. These log the architectural choices we've made, why we've made them, and the consequences.

This doesn't duplicate [govuk-one-login/architecture], which has a different intended audience and permissions model.

Strategic decisions, with cross programme consequence, continue to live in [govuk-one-login/architecture] where architecture leads review them.

Tactical decisions within the team, describing how we structure this project, live in this repository. The team reviews and updates them.

## Context

We'd like to record the decisions to help contributors understand the rationale behind the architecture of the project. In the development of [govuk-one-login/mobile-android-cri-orchestrator], we make architectural decisions impacting future work. The rationale behind these decisions isn't always clear when looking at the code alone.

We also want a place to document our team's decisions which don't need a full cross-programme review. ADRs with strategic implications in [govuk-one-login/architecture] need a review from a Lead Architect, Security and Technical Writer. Teams have autonomy to design and deliver a solution within those goalposts.

The intended audience for these documents include:

- New developers to the team who are trying to understand this project.
- Developers from other teams curious to see our implementation and compare ideas.
- Developers within the team, looking for a reference architecture when delivering work.

## Format

We should keep formatting simple:

- Infer dates and authors from the Git history.
- Write in markdown.
- Aim to keep headings consistent with this PR, although they can vary if needed.
- Once the team has reviewed and merged an ADR, they have adopted the decision.
- Deprecate superseded ADRs by amending them with `Status: superseded.` Contributors must add a link referencing any new ADR or reason.

## Consequences

- We'll store ADR records relating to [govuk-one-login/mobile-android-cri-orchestrator] in `docs/adr`.
- Where there are cross programme consequences, we may have a stub here, but it should point to a cross programme ADR in [digital-identity-architecture](https://github.com/alphagov/digital-identity-architecture).

[govuk-one-login/architecture]: https://github.com/govuk-one-login/architecture
[govuk-one-login/mobile-android-cri-orchestrator]: https://github.com/govuk-one-login/mobile-android-cri-orchestrator

<!-- vale Google.We = YES -->
