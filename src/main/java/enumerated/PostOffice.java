package enumerated;

import utils.Enums;
import utils.PrintUtil;

import java.util.Iterator;

/**
 * Created by yuez on 14-1-23
 * Modeling a post office
 */
public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY {
            boolean handle(Mail m) {
                switch (m.delivery) {
                    case YES:
                        PrintUtil.print("Using general delivary for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            boolean handle(Mail m) {
                switch (m.scannablity) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                PrintUtil.print("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                switch (m.transferAddress) {
                                    case MISSING:
                                        return false;
                                    default:
                                        PrintUtil.print("Transferring " + m + " already");
                                        return true;
                                }
                            default:
                                PrintUtil.print("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            boolean handle(Mail m) {
                switch (m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        PrintUtil.print("Returning " + m + " to sender");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail m);
    }

    static void handle(Mail m) {
        for (MailHandler handler : MailHandler.values())
            if (handler.handle(m))
                return;
        PrintUtil.print(m + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(1000)) {
            PrintUtil.print(mail.details());
            handle(mail);
            PrintUtil.print("******");
            PrintUtil.print();
        }
    }
}

class Mail {
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum TransferAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery delivery;
    Scannability scannablity;
    Readability readability;
    Address address;
    TransferAddress transferAddress;
    ReturnAddress returnAddress;

    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                '}';
    }

    public String details() {
        return toString() +
                " General Delivery: " + delivery +
                " Address Scannability: " + scannablity +
                " Address Readability: " + readability +
                " Address Address: " + address +
                " Transfer Address: " + transferAddress +
                " Return Address: " + returnAddress;
    }

    public static Mail randomMail() {
        Mail m = new Mail();
        m.delivery = Enums.random(GeneralDelivery.class);
        m.scannablity = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.transferAddress = Enums.random(TransferAddress.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
