export class Player {
    id: string;
    name: string;
    email: string;
    hash: string;
    remote = false;
    teamId: string;

    set $remote(remote: string) {
        this.remote = remote === 'R';
    }

    get $remote(): string {
        return this.remote ? 'R' : 'P';
    }
}
