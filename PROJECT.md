# Design & Archtecture of Erbut

> An Elegant Web Based Linkfolio

**Students:**

- Yazeed AlKhalaf
- Khalil Melhem
- Khaled Hazzam

**Course:** SWE 302 - Software Design & Architecture

**Instructor:** Dr. Ahmed Ghoneim

---

## Table of Contents

- [Design \& Archtecture of Erbut](#design--archtecture-of-erbut)
  - [Table of Contents](#table-of-contents)
  - [Abstract](#abstract)
  - [System Overview](#system-overview)
    - [Big Picture](#big-picture)
    - [Abstract View](#abstract-view)
    - [Subsystem View](#subsystem-view)
    - [Functionalities of The Subsystems](#functionalities-of-the-subsystems)
      - [Database `<<internal>>`](#database-internal)
      - [Authentication `<<internal>>`](#authentication-internal)
      - [Website `<<internal>>`](#website-internal)
      - [Linkfolio Parser `<<internal>>`](#linkfolio-parser-internal)
      - [Emailer `<<internal>>`](#emailer-internal)
      - [Image Uploader `<<internal>>`](#image-uploader-internal)
      - [Subscribe `<<internal>>`](#subscribe-internal)
      - [Webhook Handler `<<internal>>`](#webhook-handler-internal)
      - [Analytics `<<internal>>`](#analytics-internal)
      - [Google Analytics `<<external>>`](#google-analytics-external)
      - [Google Cloud `<<external>>`](#google-cloud-external)
      - [Stripe `<<external>>`](#stripe-external)
      - [Resend `<<external>>`](#resend-external)

---

## Abstract

Erbut presents a dynamic, web-based platform enabling users to create and manage personalized 'Erbuts'—elegant linkfolios showcasing a curated list of links. These linkfolios, hosted as subdomains on erbut.me or linked to custom domains, offer a unique way to display online presence.

Additionally, users can integrate Google Analytics for enhanced data collection. The subscription model, facilitated via Stripe, unlocks premium features, enhancing user experience and customization. Erbut stands out as a versatile solution for creating and monitoring professional and personal online portfolios and brands.

This paper extensively explores the design and architecture of Erbut, focusing on its robust, scalable backend and user-friendly frontend. It highlights the integration of technologies for domain management, analytics, and payment processing, emphasizing the platform's efficiency and security.

## System Overview

This section will showcase the system from an internal point of view. Using UML diagrams to draw the system, reading this section should allow the reader to understand how the system is built on a high level.

### Big Picture

> ![Figure 1 - Big Picture Diagram][figure1]
>
> **Figure 1 - Big Picture Diagram**

The Big Picture diagram sketch seen in **Figure 1** provides a high-level overview of Erbut’s system architecture, highlighting its backend central to operations, integrating with services like Vercel, Stripe, Resend, Sign in with Apple, Google OAuth, Google Cloud, and Google Analytics.

### Abstract View

> ![Figure 2 - Black Box Diagram of the System][figure2]
>
> **Figure 2 - Black Box Diagram of the System**

The abstract view diagram seen in **Figure 2** helps us understand the inputs the system requires and the outputs it will produce. A glance at the diagram shows that we use Customer Details to create an account initially and then to verify the user's identity in subsequent interactions. Website Details are used to construct the Erbut Linkfolio. Additionally, Stripe webhooks provide real-time information about our users’ subscription statuses.

### Subsystem View

> ![Figure 3 - Sub-System View of Erbut][figure3]
>
> **Figure 3 - Sub-System View of Erbut**

The subsystem diagram found below in **Figure 3** represents all the components that our system (Erbut) consists of internally and externally. External subsystems represent the components we are using directly without building them from scratch. On the other hand, internal subsystems are built by us from the ground up.

### Functionalities of The Subsystems

This section highlights description of the sub-systems previously presented in **Figure 3** (Sub-System View of Erbut):

#### Database `<<internal>>`

- Stores the data for the system, such as our customers’ details and their website data.

#### Authentication `<<internal>>`

- Responsible for the authentication of users whether it’s their first time accessing the system or a regular user.
- Integrates with Google OAuth and Sign in with Apple to offer more authentication options.

#### Website `<<internal>>`

- API for the front-end to allow the customer to create and manage websites (Erbuts).

#### Linkfolio Parser `<<internal>>`

- It fills out the template of the Erbut based on the data in the database. It knows which Erbut to query by its subdomain. It then parses the template and fills it with data, then finally returns it to the client.

#### Emailer `<<internal>>`

- This service is responsible for sending emails. Other systems like Authentication depend on it to send verification and reset password emails. It accepts email and a template id.

#### Image Uploader `<<internal>>`

- This service allows customers to upload an image and get a url for it. This is helpful to put images in their Erbuts by hosting it on our servers.

#### Subscribe `<<internal>>`

- This service allows the customer to manage their billing information and subscribe or change their plan.

#### Webhook Handler `<<internal>>`

- This service allows Stripe, our payment gateway, to send us updates about our customers' billing state. Whether they are subscribed, paid, did not pay, or even are late on payment.

#### Analytics `<<internal>>`

- This service collects and aggregates data from the Erbuts and saves it for our customers to view and take decisions based on it.

#### Google Analytics `<<external>>`

- Collects and analyzes data of visitors and their behaviors when visiting a customer’s Erbut (Linkfolio).

#### Google Cloud `<<external>>`

- Responsible for providing computing resources, data storage, and hosting the system backend services.
- It’s a cloud computing service that runs on the same infrastructure that Google uses for its own products.

#### Stripe `<<external>>`

- Responsible for handling all payment transactions, including processing customer credit cards, managing secure payment information, and handling subscription billing services.

#### Resend `<<external>>`

- Responsible for automated email communications, such as account verification, notification, and other automated email responses based on user actions or system triggers.

[figure1]: ./project-images/erbut-big-picture.png
[figure2]: ./project-images/erbut-abstract-view.png
[figure3]: ./project-images/erbut-package-diagram.png
