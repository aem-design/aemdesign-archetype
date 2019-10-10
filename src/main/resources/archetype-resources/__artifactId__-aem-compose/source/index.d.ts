declare var require: {
  <T>(path: string): T;
  (paths: string[], callback: (...modules: any[]) => void): void;
  ensure: (
    paths: string[],
    callback: (require: <T>(path: string) => T) => void
  ) => void;
}

declare interface Window { CQ: any; }

declare function ObjectFitImages(): void;

declare type FormInputCallback = (($target: JQuery, $input: JQuery, event: JQuery.TriggeredEvent) => boolean) | void;

declare type SubscriberTree = {
  default: SubscriberHandler,
}

declare type SubscriberHandler = (event: JQuery.Event, originalEvent: JQuery.TriggeredEvent, type: string) => void;
