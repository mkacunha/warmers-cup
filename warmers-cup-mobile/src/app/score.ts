export class Score {
    teamId: number;
    categoryId: number;
    amount: number;

    _team: any;
    _category: any;

    set $team(team: any) {
        this._team = team;
        this.teamId = team.id;
    }

    get $team(): any {
        return this._team;
    }


    set $category(category: any) {
        this._category = category;
        this.categoryId = category.id;
    }

    get $category(): any {
        return this._category;
    }

    get isValid(): boolean {
        return this.teamId && this.categoryId && this.amount && this.amount > 0;
    }
}
